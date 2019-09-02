package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newer.domain.Tea;
import com.newer.service.TeaSerice;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet( "/tea")
public class TeaServlet extends HttpServlet {
    private TeaSerice teaSerice;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Tea tea=new Tea();
        try {
            BeanUtils.populate(tea,request.getParameterMap());
            int result=teaSerice.addTea(tea);
            JsonObject jo=new JsonObject();
            jo.addProperty("result",result);
            Gson gson=new Gson();
            PrintWriter out=response.getWriter();
            out.print(jo);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    public void init() throws ServletException {
        teaSerice= new TeaSerice();
    }
}
