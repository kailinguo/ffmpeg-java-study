package video.screenshot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KaiLin.Guo on 2018-05-29.
 */
public class ScreenShotProcess {

    /**
     * 视频截图
     * @param video_path
     * @param ffmpeg_path
     * @param image_name
     * @param time
     * @return
     */
    public static boolean processImg(String video_path, String ffmpeg_path, String image_name, float time) {
        File file = new File(video_path);
        if (!file.exists()) {
            System.out.println("路径[" + video_path + "]对应的视频文件不存在!");
            return false;
        }
        List<String> commands = new ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-ss");
        commands.add(String.valueOf(time));
        commands.add("-i");
        commands.add(video_path);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-s");
        commands.add("700x525");
        commands.add("target/classes/video/" + image_name + ".jpg");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            System.out.println(video_path + ",第 " + time + " 秒截取成功...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean processGif(String video_path, String ffmpeg_path, String image_name, float time) {
        File file = new File(video_path);
        if (!file.exists()) {
            System.out.println("路径[" + video_path + "]对应的视频文件不存在!");
            return false;
        }
        List<String> commands = new ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-ss");
        commands.add("00:00:20");
        commands.add("-t");
        commands.add(String.valueOf(time));
        commands.add("-i");
        commands.add(video_path);
        commands.add("-vf");
        commands.add("crop=iw:ih*2/3");
        commands.add("-y");
        commands.add("-s");
        commands.add("320x240");
        commands.add("target/classes/video/" + image_name + ".gif");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            System.out.println(video_path + "动图生成成功...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
