package woojy.kr.hs.emirim.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.599399, 126.926026),15));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public static final int ITEM_SATTELLITE=1;
    public static final int ITEM_NOMAL=2;
    public static final int ITEM_HS=3;
    public static final int ITEM_EVERLAND=4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,ITEM_SATTELLITE,0,"위성지도");
        menu.add(0,ITEM_NOMAL,0,"일반지도");
        SubMenu hotMenu=menu.addSubMenu("핫플레이스");
        hotMenu.add(0,ITEM_HS,0,"우리고등학교");
        hotMenu.add(0,ITEM_EVERLAND,0,"환상의나라");
        //menu.add(0,ITEM_HS,0,"우리고등학교");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case ITEM_SATTELLITE: googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case ITEM_NOMAL: googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case ITEM_HS: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.466554, 126.932962),15));
                return true;
            case ITEM_EVERLAND: googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.294132, 127.202577),15));
                return true;
        }
        return false; //항목이 선택되었을 때만 true 임 엘레레렐
    }
}
