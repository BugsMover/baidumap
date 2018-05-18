package cn.baidumap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends AppCompatActivity {
    private MapView mMapView = null;
    //private MapView mMapView;
    private BaiduMap mBaiduMap;
    final private int map_TYPE_SATELLIIE = 2;
    final private int map_TYPE_NONE = 3;
    final private int BaiduHeatMap = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //获取地图控件引用
       mMapView = (MapView) findViewById(R.id.bmapView);
        //mMapView = (MapView) findViewById(R.id.mmap);
        mBaiduMap = mMapView.getMap();
//        MAP_TYPE_NORMAL	普通地图（包含3D地图）
//        MAP_TYPE_SATELLITE	卫星图
//        MAP_TYPE_NONE	空白地图
        //普通地图，mBaiduMap是地图控制对象
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //卫星地图
        //mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
        //空白地图
        //mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
        //开启交通图
        //mBaiduMap.setBaiduHeatMapEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(1,map_TYPE_SATELLIIE,0,"卫星地图");
        menu.add(1,map_TYPE_NONE,0,"空白地图");
        menu.add(1,BaiduHeatMap,0,"交通地图");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case map_TYPE_SATELLIIE:
                Intent intent = new Intent(MainActivity.this,map_type_satekkiie_activity.class);
                startActivity(intent);
                break;
            case map_TYPE_NONE:
                Intent intent1 = new Intent(MainActivity.this,map_type_none_activity.class);
                startActivity(intent1);
                break;
            case BaiduHeatMap:
                Intent intent2 = new Intent(MainActivity.this,BaiduHeatMap_activity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
