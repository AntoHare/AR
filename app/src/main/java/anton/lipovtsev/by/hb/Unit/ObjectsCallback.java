package anton.lipovtsev.by.hb.Unit;

import org.rajawali3d.cameras.Camera;
import org.rajawali3d.math.Matrix4;
import org.rajawali3d.renderer.Renderer;

/**
 * Created by linweijie on 6/20/16.
 */
public interface ObjectsCallback {
    void parse(Renderer renderer);
    void render(Camera camera, Matrix4 vpMatrix, Matrix4 projMatrix, Matrix4 vMatrix);
    void visible(boolean visible);
}
