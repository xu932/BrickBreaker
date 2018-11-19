package Media;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {

	public static BufferedImage[] images;
	public static BufferedImage[] Option;
	public static BufferedImage[] blocks;
	public static BufferedImage[] gameBackground;

	public Image() {

		images = new BufferedImage[20];
		Option = new BufferedImage[19];
		blocks = new BufferedImage[3];
		gameBackground = new BufferedImage[3];
		try {
			images[0] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/HomePage.jpg")); // 400*600
			images[1] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/BG.jpg")); // 400*600
			images[2] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/Play_1.png")); // 129*43
			images[3] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/Play_2.png")); // 129*43
			images[4] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/HTP_1.png")); // 126*24
			images[5] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/HTP_2.png")); // 126*24
			images[6] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/board.png")); // 55*13
			images[7] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/BackToMenu.png")); // 200*43
			images[8] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/BackToMenu2.png")); // 200*43
			images[9] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/GoodLuck.png")); // 225*177
			images[10] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/Ball.png")); // 216*216
			images[11] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/crown.png"));	// 60*60
			images[12] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/crown_2.png"));	// 60*60
			images[13] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/rankingBG.jpg"));

			Option[0] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_01.png"));
			Option[1] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_02.png"));
			Option[2] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_03.png"));
			Option[3] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_04.png"));
			Option[4] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_05.png"));
			Option[5] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_06.png"));
			Option[6] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_07.png"));
			Option[7] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_08.png"));
			Option[8] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/Option_09.png"));

			Option[9] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/mouse.png")); // 415*289
			Option[10] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/mouseAct.png")); // 415*289
			Option[11] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/KB.png")); // 562*224
			Option[12] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/KBAct.png")); // 562*224

			Option[13] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/N1.png")); // 268*268
			Option[14] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/N1Act.png")); // 268*268
			Option[15] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/N2.png")); // 268*268
			Option[16] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/N2Act.png")); // 268*268
			Option[17] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/N3.png")); // 268*268
			Option[18] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/OptionGIF/N3Act.png")); // 268*268

			blocks[0] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/Block/blockG.png"));
			blocks[1] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/Block/blockP.png"));
			blocks[2] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/Block/blockY.png"));

			gameBackground[0] = ImageIO.read(getClass().getResourceAsStream(
					"/Images/GameBackground/GameBG_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}