package lk.study.custom_class;

import java.util.List;

import lk.study.uistudy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 自定义Adapter继承自BaseAdapter
 * 用于Spinner设置Adapter
 * UiLayoutActivity中的 setSpinner2() 方法调用
 * @author Mr.li
 *
 */
public class SpinnerDataAdapter extends BaseAdapter {

	List<SpinnerDataClass> mUsers ;
	Context mContext ;
	
	public SpinnerDataAdapter(Context context, List<SpinnerDataClass > users){
		mContext = context ;
		mUsers = users ;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mUsers.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mUsers.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(mContext).inflate(R.layout.spinner_item, null);
		TextView tvName = (TextView) convertView.findViewById(R.id.tvName) ;
		TextView tvAddress = (TextView) convertView.findViewById(R.id.tvAddress) ;
		
		tvName.setText(mUsers.get(position).getmName()) ;
		tvAddress.setText(mUsers.get(position).getmAddress()) ;
		
		return convertView;
	}

}
