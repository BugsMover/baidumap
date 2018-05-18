package cn.baidumap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

public class map_type_satekkiie_activity extends AppCompatActivity {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    final private int MainAcivity = 2;
    final private int map_TYPE_NONE = 3;
    final private int BaiduHeatMap = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_type_satekkiie_activity);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(1,MainAcivity,0,"普通地图");
        menu.add(1,map_TYPE_NONE,0,"空白地图");
        menu.add(1,BaiduHeatMap,0,"交通地图");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MainAcivity:
                Intent intent = new Intent(map_type_satekkiie_activity.this,MainActivity.class);
                startActivity(intent);
                break;
            case map_TYPE_NONE:
                Intent intent1 = new Intent(map_type_satekkiie_activity.this,map_type_none_activity.class);
                startActivity(intent1);
                break;
            case BaiduHeatMap:
                Intent intent2 = new Intent(map_type_satekkiie_activity.this,BaiduHeatMap_activity.class);
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
