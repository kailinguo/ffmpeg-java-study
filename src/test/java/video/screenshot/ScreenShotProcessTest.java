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
        image_name = "shot";
        float time = 5;

        ScreenShotProcess.processImg(video_path, ffmpeg_path, image_name, time);
    }

}