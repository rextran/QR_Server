package qrGene;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
public class QRCodeGenerator {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss_ddMMyy");  
	LocalDateTime now = LocalDateTime.now(); 
	public QRCodeGenerator(String id) {
		System.out.println(dtf.format(now));  
		String QR_CODE_IMAGE_PATH = "/QR_Server/WebContent/img/" + id + "_"+ dtf.format(now) + ".png";
		System.out.println(QR_CODE_IMAGE_PATH);
		try {
			generateQRCodeImage(id, 350, 350, QR_CODE_IMAGE_PATH);

		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}

