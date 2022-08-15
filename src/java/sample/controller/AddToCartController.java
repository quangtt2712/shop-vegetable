/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.daos.ProductDAO;
import sample.dtos.AddToCart;
import sample.dtos.Product;

/**
 *
 * @author 2
 */
public class AddToCartController extends HttpServlet {

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
            int productId = Integer.parseInt(request.getParameter("productId"));
//            List<Product> listProducts = new ProductDAO().getProductById(productId);
            //lấy session xuống
            HttpSession session = request.getSession();
            //lấy cart trên session xuống
            Map<Integer, AddToCart> carts = (Map<Integer, AddToCart>) session.getAttribute("carts");
            if(carts == null) {
                //linkerhashmap kick vào đâu là có thứ tự add nên dùng
                carts = new LinkedHashMap<>();
            }
            if (carts.containsKey(productId)) {// sản phẩm có trên giỏ hàng
                int oldQuantity = carts.get(productId).getQuantity();
                carts.get(productId).setQuantity(oldQuantity + 1);
            }else{//sản phẩm chưa có trên giỏ hàng
                Product product = new ProductDAO().getProductById(productId);
                carts.put(productId, AddToCart.builder()
                        .product(product)
                        .quantity(1)
                        .build());
                //xong thì lưu cart lên session
            }
            session.setAttribute("carts", carts);
            System.out.println(carts);
            response.sendRedirect("home");
            //map productId||cart
            //get cái key cho sản phẩm
            // nhược điểm của list khi lấy đối tượng tương ướng id thì phải duyệt list và bằng id
            //có collection hashmap dùng đi
            //Nói đơn giản hơn thì HashMap về cơ bản chỉ định các 
            //unique key cho các value tương ứng có thể được truy xuất tại bất kỳ điểm nào.
            //value ko bao giờ trùng nhau, mỗi cái key thì value là cái cart
            //1.Lấy productId ứng với id nhận dc
            //2.có 2 trường hợp 
            //TH1 là sản phẩm chưa có trên giỏ hàng - Thêm nó vào giỏ hàng (add product to session)
            //Th2 là sản phẩm đã có trên giỏ hàng - cập nhập quantity(Update to session)
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
