/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiepv
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    public int GCD(int a, int b){
        int min = Math.min(a, b);
        for(int i=min; i>=1; i--){
            if(a%i==0 &&b%i==0){
                return i;
            }
        }
        return 1;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String txtA = request.getParameter("txtA");
        String txtB = request.getParameter("txtB");
        // Check input
        if (txtA == null || txtA.trim().length() == 0) {
            out.println("Please input A");
            return;
        }

        if (txtB == null || txtB.trim().length() == 0) {
            out.println("Please input B");
            return;
        }
        // Check value
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(txtA);
            b = Integer.parseInt(txtB);
            
            // Check a and b >0
            if(a<=0){
                out.println("A must be greater than 0!");
                return;
            }
            
            if(b<=0){
                out.println("B must be greater than 0!");
                return;
            }
        }catch(Exception e){
            out.println("A and B must be intergers!");
            return;   
        }
        
        // output result
        int result =GCD(a, b);
        out.println("Greatest Common Divisor("+a+","+b+")="+result);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
