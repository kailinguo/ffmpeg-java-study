package video.screenshot;

import org.junit.Test;

/**
 * Created by KaiLin.Guo on 2018-05-29.
 */
public class ScreenShotProcessTest {
    @Test
    public void processImg() throws Exception {
        String video_path = "target/classes/video/Wildlife.wmv",
            ffmpeg_path = "target/classes/tool/ffmpeg.exe",
        image_name = "img";
        float time = 5;

        ScreenShotProcess.processImg(video_path, ffmpeg_path, image_name, time);
    }

    @Test
    public void processGif() throws Exception {
        String video_path = "target/classes/video/Wildlife.wmv",
                ffmpeg_path = "target/classes/tool/ffmpeg.exe",
                image_name = "gif";
        float time = 10;

        ScreenShotProcess.processGif(video_path, ffmpeg_path, image_name, time);
    }

}