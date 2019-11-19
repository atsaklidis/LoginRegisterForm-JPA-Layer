/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Customer;
import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tsak
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      CustomerDAO cs= new CustomerDAO();
        
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String button= request.getParameter("submit");
        
        Customer c= cs.CustomerGet(username);
        if(c == null){
            c = new Customer();
        }
        
        if(button.equals("Sign In") && c.getFirstName() != null){
            if(c.getPassword().equals(password)){//successful sign in
                request.setAttribute("success_message", c.getFirstName());
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
            else{//user exists but wrong password
                request.setAttribute("wrong_password_message", "Wrong password.");
                request.getRequestDispatcher("index.jsp").forward(request, response); 
            }
        }else if(button.equals("Sign Up")){//Sign up for new user
            String first_name= request.getParameter("first_name");
            String last_name= request.getParameter("last_name");
            String e_mail= request.getParameter("email");
            if(username.length()==0 || first_name.length()==0 || password.length()==0){
                request.setAttribute("missing_info_message", "Missing information.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else if(c.getUsername() != null){
                request.setAttribute("user_exists_message", "User already exists.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else{
                c.setUsername(username);
                c.setFirstName(first_name);
                c.setLastName(last_name);
                c.setEmail(e_mail);
                c.setPassword(password);
                cs.CustomerAdd(c);
                request.setAttribute("success_message", c.getFirstName());
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
        }
        else{//not-existing user
            request.setAttribute("user_not_exist_message", "User doesn't exist.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
