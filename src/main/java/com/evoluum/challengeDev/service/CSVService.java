package com.evoluum.challengeDev.service;

import com.evoluum.challengeDev.view.AbstractCsvView;
import com.evoluum.challengeDev.view.TypeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class CSVService {

    @Autowired
    private HttpServletResponse httpServletResponse;

    private  void download(byte [] bytes, final String name, TypeFile tipo) throws IOException {
        httpServletResponse.setContentType("text/" + tipo.getExtensao() );
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"."+tipo.getExtensao());
        OutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write( bytes  );
        outputStream.flush();
        outputStream.close();
    }

    @SuppressWarnings("rawtypes")
    public void download(AbstractCsvView arquivo) throws IOException {
        download(
                arquivo.getBytes(),
                arquivo.getName(),
                arquivo.getTypeFile()
        );
    }
}
