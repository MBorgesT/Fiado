package printers;

import dao.AtendenteDAO;
import dao.ClienteDAO;
import dao.CompraDAO;
import fiado.FilesFolder;
import gui_cliente.NovaCompra;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Atendente;
import models.Cliente;
import models.Compra;
import models.Pagamento;
import org.json.JSONException;
import org.json.JSONObject;

public class ComprovantePrinter {
    
    private static String baseFolder =  FilesFolder.path + "printer-scripts/";
    
    private static String pathCompraCliente = "python3 " + baseFolder + "print_compra_cliente.py";
    private static String pathCompraPadaria = "python3 " + baseFolder + "print_compra_padaria.py";
    
    private static String pathCompraEntregaCliente = "python3 " + baseFolder + "print_compra_entrega_cliente.py";
    private static String pathCompraEntregaPadaria = "python3 " + baseFolder + "print_compra_entrega_padaria.py";
    
    private static String pathPagamentoCliente = "python3 " + baseFolder + "print_pagamento_cliente.py";
    private static String pathPagamentoPadaria = "python3 " + baseFolder + "print_pagamento_padaria.py";
    
    private static String pathJsonCompra = baseFolder + "compra.json";
    private static String pathJsonCompraEntrega = baseFolder + "compraEntrega.json";
    private static String pathJsonPagamento = baseFolder + "pagamento.json";

    public static void printComprovanteCompra(Compra compra, boolean isCliente) {
        try {
            Cliente cliente = ClienteDAO.selectClienteById(compra.getIdCliente());
            Atendente atendente = AtendenteDAO.selectAtendenteById(compra.getIdAtendente());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String valor = String.format("%.02f", compra.getValor());
            valor = valor.replace('.', ',');
            
            String obs = compra.getObservacao() == "" ? "null" : compra.getObservacao();
            
            JSONObject json = new JSONObject();
            json.put("id_compra", String.valueOf(compra.getIdCompra()));
            json.put("data", compra.getFormattedData());
            json.put("valor", valor);
            json.put("cliente", cliente.getNome());
            json.put("atendente", atendente.getNome());
            json.put("observacao", obs);
            
            FileWriter file = new FileWriter(pathJsonCompra);
            file.write(json.toString());
            file.flush();
            file.close();
            
            if (isCliente) {
                Runtime.getRuntime().exec(pathCompraCliente);
            } else {
                Runtime.getRuntime().exec(pathCompraPadaria);
            }
        } catch (JSONException ex) {
            Logger.getLogger(ComprovantePrinter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ComprovantePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printComprovanteCompraEntrega(Compra compra, boolean isCliente) {
        try {
            Cliente cliente = ClienteDAO.selectClienteById(compra.getIdCliente());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String valor = String.format("%.02f", compra.getValor());
            valor = valor.replace('.', ',');
            
            String obs = compra.getObservacao() == "" ? "null" : compra.getObservacao();
            
            JSONObject json = new JSONObject();
            json.put("id_compra", String.valueOf(compra.getIdCompra()));
            json.put("data", compra.getFormattedData());
            json.put("valor", valor);
            json.put("cliente", cliente.getNome());
            json.put("observacao", obs);
            
            FileWriter file = new FileWriter(pathJsonCompraEntrega);
            file.write(json.toString());
            file.flush();
            file.close();
            
            if (isCliente) {
                Runtime.getRuntime().exec(pathCompraEntregaCliente);
            } else {
                Runtime.getRuntime().exec(pathCompraEntregaPadaria);
            }
        } catch (JSONException ex) {
            Logger.getLogger(ComprovantePrinter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ComprovantePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printComprovantePagamento(Pagamento pagamento, boolean isCliente){
        try {
            Cliente cliente = ClienteDAO.selectClienteById(pagamento.getIdCliente());
            Atendente atendente = AtendenteDAO.selectAtendenteById(pagamento.getIdAtendente());
            ArrayList<Compra> arrayCompras = CompraDAO.selectComprasFromPagamento(pagamento.getIdPagamento());

            String obs = pagamento.getObservacao().isEmpty() ? "null" : pagamento.getObservacao();

            JSONObject json = new JSONObject();
            json.put("id_pagamento", String.valueOf(pagamento.getIdPagamento()));
            json.put("data", pagamento.getFormattedData());
            json.put("valor", pagamento.getFormattedValor());
            json.put("cliente", cliente.getNome());
            json.put("atendente", atendente.getNome());
            json.put("observacao", obs);
            json.put("qtd_compras", String.valueOf(arrayCompras.size()));
            for (int i = 0; i < arrayCompras.size(); i++) {
                String dataAux = "compra_data" + String.valueOf(i);
                json.put(dataAux, arrayCompras.get(i).getFormattedData());

                String valorAux = "compra_valor" + String.valueOf(i);
                json.put(valorAux, arrayCompras.get(i).getFormattedValor());
            }

            FileWriter file = new FileWriter(pathJsonPagamento);
            file.write(json.toString());
            file.flush();
            file.close();

            if (isCliente) {
                Runtime.getRuntime().exec(pathPagamentoCliente);
            } else {
                Runtime.getRuntime().exec(pathPagamentoPadaria);
            }

        } catch (IOException ex) {
            System.out.println("io exception impressão compra");
            Logger.getLogger(NovaCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(NovaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
