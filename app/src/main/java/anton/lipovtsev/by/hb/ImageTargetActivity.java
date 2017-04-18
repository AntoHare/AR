package anton.lipovtsev.by.hb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import anton.lipovtsev.by.hb.Unit.BaseVuforiaActivity;
import anton.lipovtsev.by.hb.Unit.CollisionCallback;
import anton.lipovtsev.by.hb.Unit.Model3D;
import java.util.ArrayList;

public class ImageTargetActivity extends BaseVuforiaActivity implements View.OnClickListener {

    ArrayList<Model3D> arrayList;
    Model3D tempM3D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        initAR();
        super.onCreate(savedInstanceState);
        setShowModels();
        addCustomView();

        this.setCollisionCallback(new CollisionCallback() {
            @Override
            public void ObjectCollision(int objId1, int objId2) {
                Log.d("ImageTargetActivity", "Object " + objId1 + " is Collision by Object " + String.valueOf(objId2));
                if (objId1==2||objId2==2){
                    Model3D temp = ImageTargetActivity.this.getModel3DArrayList().get(2);
                    temp.transitionAnimation(0,1,1000,2000);
                }
            }
        });
    }

    private void initAR(){
        // set mode
        this.setARMode(BaseVuforiaActivity.MODE_ImageTarget);

        // set local target library
        ArrayList<String> dataString = new ArrayList<>();
        dataString.add("Test.xml");
        this.setDatasetStrings(dataString);

        // set max targets will show in same time
        this.setMAX_TARGETS_COUNT(1);
    }

    private void setShowModels(){
// set show models
        arrayList = new ArrayList<>();

        tempM3D = new Model3D(this, R.raw.video);
        tempM3D.setMODE(Model3D.LOAD_VIDEO_PLANE);
        tempM3D.setObj_scale(12.0f);
        tempM3D.setObj_translate_x(0.0f);
        tempM3D.setObj_translate_y(0.0f);
        tempM3D.setObj_rotate_angle(180.0f);
        tempM3D.setObj_rotate_y(90.0f);

        arrayList.add(tempM3D);

        tempM3D = new Model3D(this, R.raw.cat);
        tempM3D.setObj_scale(30f);
        tempM3D.setObj_rotate_angle(90.0f);

        arrayList.add(tempM3D);

        this.setModel3DArrayList(arrayList);
    }

    private void addCustomView(){
        // add custom view
        View root = findViewById(android.R.id.content);
        View.inflate(this, R.layout.sub_custom, (ViewGroup) root);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "This is ImageTarget Sample.", Toast.LENGTH_SHORT).show();
    }
}
