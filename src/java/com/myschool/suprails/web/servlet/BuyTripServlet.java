/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.web.servlet;

import com.myschool.suprails.entity.Customer;
import com.myschool.suprails.entity.CustomerOrder;
import com.myschool.suprails.entity.Trip;
import com.myschool.suprails.service.CustomerOrderService;
import com.myschool.suprails.service.MessageService;
import com.myschool.suprails.service.TripService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thibault
 */
@WebServlet(name = "BuyTripServlet", urlPatterns = {"/trips/buy"})

public class BuyTripServlet extends HttpServlet{
    
    @EJB
    private CustomerOrderService customerOrderService;
    @EJB
    private TripService tripService;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
      req.getRequestDispatcher("/jsp/buyTrip.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        Long tripId = Long.valueOf(idParam);
        
        Trip trip = tripService.findTripById(tripId);
        Customer customer = new Customer(firstName, lastName, email);
        
        CustomerOrder customerOrder = new CustomerOrder(customer, trip);
        customerOrderService.sendMail(email);
        try {
            customerOrderService.processCustomerOrder(customerOrder);
        } catch (JMSException ex) {
            Logger.getLogger(BuyTripServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/trips");
    }
}
