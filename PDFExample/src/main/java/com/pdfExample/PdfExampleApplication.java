package com.pdfExample;

import com.pdfExample.pdf.CreateNewPdf;
import com.pdfExample.pdf.PdfEdit;
import com.pdfExample.pdf.PdfGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PdfExampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(PdfExampleApplication.class, args);
		System.out.println("Hello Spring Boot Pdf");

//		PdfGenerator pdfGenerator = new PdfGenerator();
//		pdfGenerator.generatePDF();
//		PdfEdit pdfEdit = new PdfEdit();
//		pdfEdit.pdfEdit1();
//		CreateNewPdf createNewPdf = new CreateNewPdf();
//		createNewPdf.latestPdf();
	}

}
