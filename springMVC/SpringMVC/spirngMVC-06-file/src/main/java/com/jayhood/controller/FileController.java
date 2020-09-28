package com.jayhood.controller;

import jdk.internal.util.xml.impl.Input;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@RestController
public class FileController {

    // @RequestParam("file") 将name=file控件得到的文件封装成
    // CommonsMultipartFile 对象
    // 批量上传CommonsMultipartFile则为数组即可
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        String filename = file.getOriginalFilename();

        if ("".equals(filename))
            return "redirect:/index.jsp";

        System.out.println("上传文件名: " + filename);
        // 上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址: " + realPath);

        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(new File(realPath,filename));

        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();;
        is.close();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        // 上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload-diunima");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址: " + realPath);

        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String downloads(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String path = request.getServletContext().getRealPath("/upload");
        String filename = "river.jpg";

        response.reset(); // 设置页面不缓存，清空buffer
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "utf-8"));

        File file = new File(path, filename);

        InputStream is = new FileInputStream(file);
        OutputStream os = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int index = 0;
        while ((index = is.read(buffer)) != -1) {
            os.write(buffer, 0, index);
            os.flush();
        }

        os.close();
        is.close();
        return  null;

    }
}
