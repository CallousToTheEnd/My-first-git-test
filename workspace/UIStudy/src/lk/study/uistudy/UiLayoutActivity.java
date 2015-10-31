package lk.study.uistudy;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import lk.study.custom_class.SpinnerDataAdapter;
import lk.study.custom_class.SpinnerDataClass;
import lk.study.uistudy.R;



public class UiLayoutActivity extends Activity {

	TextView tv1 ;
	Button btnUiLayout ;
	ToggleButton tbtnUiLayout ;
	RadioGroup RadioGroup ;
	Spinner spinner ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_layout) ;
		
		showTv1() ;
		setButton() ;
		setToggleButton() ;
		setRadioButton() ;
//		setSpinner() ;
		setSpinner2() ;
		setSeekBar() ;
		setAutoCompleteTextView() ;
	}
	/**
	 * tv1的设置
	 */
	public void showTv1(){
		tv1 = (TextView) findViewById(R.id.tv1) ;
		SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("#CallousToTheEnd# This is my uiLayoutActivity，very long,very good") ;
		
		ClickableSpan userName_ClickableSpan = new ClickableSpan() {
			
			@Override
			public void onClick(View widget) {
				Toast.makeText(UiLayoutActivity.this, "click", 3000).show() ;
				System.out.println("Click") ;
			}
		};
		ImageSpan imageSpan = new ImageSpan(this, R.drawable.v_icon) ;
		spannableStringBuilder.setSpan(userName_ClickableSpan, 0, 17, Spanned.SPAN_INCLUSIVE_INCLUSIVE) ;
		spannableStringBuilder.setSpan(imageSpan, 17, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) ;
		tv1.setText(spannableStringBuilder) ;
	}
	
	/**
	 * Button的点击事件
	 */
	public void setButton(){ 
		btnUiLayout = (Button) findViewById(R.id.btnUiLayout) ;
		btnUiLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("btnUiLayout Clicked") ;
			}
		});
		btnUiLayout.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				System.out.println("btnUiLayout LongClicked") ;
//				return false表示后边的继续执行， true表示后边的不再执行，默认是false
//				false的时候在执行完LongClick后还会执行Click，true不会在执行LongClick后执行Click
				return true;
			}
		});
	}
	
	/**
	 * ToggleButton设置
	 */
	public void setToggleButton(){
		tbtnUiLayout = (ToggleButton) findViewById(R.id.tbtnUiLayout) ;
		
		tbtnUiLayout.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
//					可以在这里设置一个背景图，也可以在XML中设置
					Toast.makeText(UiLayoutActivity.this, "ToggleButton is close", 3000).show() ;
				}else
					Toast.makeText(UiLayoutActivity.this, "ToggleButton is open", 3000).show() ;
			}
		}) ;
		
	}
	
	/**
	 * RadioButton
	 */
	public void setRadioButton(){
		RadioGroup = (android.widget.RadioGroup) findViewById(R.id.radioGroup) ;
		RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch(checkedId){
					case R.id.rbtn1:
						Toast.makeText(UiLayoutActivity.this, "RadioButton 1", Toast.LENGTH_SHORT).show() ;
						break ;
					case R.id.rbtn2:
						Toast.makeText(UiLayoutActivity.this, "RadioButton 2", Toast.LENGTH_SHORT).show() ;
						break ;
					case R.id.rbtn3:
						Toast.makeText(UiLayoutActivity.this, "RadioButton 3", Toast.LENGTH_SHORT).show() ;
						break ;
				}
			}
		}); 
	}

	/**
	 * spinner 的设置
	 * 静态添加XML中数据
	 */
	public void setSpinner(){
		spinner = (Spinner) findViewById(R.id.spinner1) ;
		
//		R.array.spinner_list 是在values中自定义的字符数组
		final ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(UiLayoutActivity.this, R.array.spinner_list, android.R.layout.simple_spinner_item) ;
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;
		spinner.setAdapter(spinnerAdapter) ;
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(UiLayoutActivity.this,  "SelectItem name:" + parent.getSelectedItem().toString()
						+ "position:" + position 
						+ "long:" + id, Toast.LENGTH_SHORT).show() ;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		}) ;
		
	}
	
	/**
	 * Spinner的设置
	 * 使用自定义的Adapter和数据类进行动态添加数据
	 * setSpinner()为静态添加
	 */
	public void setSpinner2(){
		spinner = (Spinner) findViewById(R.id.spinner1) ;
//		设置数据
		ArrayList<SpinnerDataClass> users = new ArrayList<>() ;
		users.add(new SpinnerDataClass("Mr.li", "shijiazhuang")) ;
		users.add(new SpinnerDataClass("Mr.du", "shijiazhuang")) ;
		users.add(new SpinnerDataClass("Mr.liu", "qinhuangddao")) ;
//		创建Adapter并连接数据
		SpinnerDataAdapter spinnerDataAdapter = new SpinnerDataAdapter(this, users) ;
		
		spinner.setAdapter(spinnerDataAdapter) ;
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(UiLayoutActivity.this, "name:" + ((TextView)view.findViewById(R.id.tvName)).getText() 
						+ " address:" + ((TextView)view.findViewById(R.id.tvAddress)).getText()
						+ " position:" + position, Toast.LENGTH_SHORT).show() ;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
	}
	
	/**
	 * SeekBar的相关设置
	 */
	public void setSeekBar(){
		SeekBar seekBar = new SeekBar(this) ;
		seekBar = (SeekBar) findViewById(R.id.seekBar1) ;
		final TextView tvSeekBarState = (TextView) findViewById(R.id.tvSeekBarState) ;
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				System.out.println("SeekBar onStopTrack");
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				System.out.println("SeekBar onStartTrack");
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				tvSeekBarState.setText("SeekBar Progress: " + seekBar.getProgress()) ;
			}
		}) ;
	}
	
	/**
	 * AutoCompleteTextView的相关设置
	 */
	private void setAutoCompleteTextView(){
		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextVeiw) ;
		String [] counties = new String[] {"1", "12", "123", "1234", "12345", "123456"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, counties);
		autoCompleteTextView.setAdapter(adapter) ;
	}
	
}
