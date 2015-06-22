package qrcode_reader;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeReader {

	
	public String getQRCode(InputStream inputStream){
		try{
			//TODO　null処理
			BufferedImage image = ImageIO.read(inputStream);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			
			// . デコード
			MultiFormatReader reader = new MultiFormatReader();
			Result result = reader.decode(bitmap);
			
			// . バーコードコンテンツ（読み取り結果）
			String text = result.getText();
			System.out.println(text);
			return text;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
