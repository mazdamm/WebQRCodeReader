package qrcode_reader;

import java.awt.image.BufferedImage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeDecoder {

	public static String decodeQRCode(BufferedImage image) throws Exception{
		String text = "";
		
//		ガード節
		if(image == null) {
			return text;
		}
		
		try{
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			// . デコード
			MultiFormatReader reader = new MultiFormatReader();
			Result result = reader.decode(bitmap);

			// . バーコードコンテンツ（読み取り結果）
			text = result.getText();
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return text;
	}
}
