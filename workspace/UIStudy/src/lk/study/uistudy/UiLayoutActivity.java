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
	 * tv1������
	 */
	public void showTv1(){
		tv1 = (TextView) findViewById(R.id.tv1) ;
		SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("#CallousToTheEnd# This is my uiLayoutActivity��very long,very good") ;
		
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
	 * Button�ĵ���¼�
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
//				return false��ʾ��ߵļ���ִ�У� true��ʾ��ߵĲ���ִ�У�Ĭ����false
//				false��ʱ����ִ����LongClick�󻹻�ִ��Click��true������ִ��LongClick��ִ��Click
				return true;
			}
		});
	}
	
	/**
	 * ToggleButton����
	 */
	public void setToggleButton(){
		tbtnUiLayout = (ToggleButton) findViewById(R.id.tbtnUiLayout) ;
		
		tbtnUiLayout.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
//					��������������һ������ͼ��Ҳ������XML������
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
	 * spinner ������
	 * ��̬���XML������
	 */
	public void setSpinner(){
		spinner = (Spinner) findViewById(R.id.spinner1) ;
		
//		R.array.spinner_list ����values���Զ�����ַ�����
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
	 * Spinner������
	 * ʹ���Զ����Adapter����������ж�̬�������
	 * setSpinner()Ϊ��̬���
	 */
	public void setSpinner2(){
		spinner = (Spinner) findViewById(R.id.spinner1) ;
//		��������
		ArrayList<SpinnerDataClass> users = new ArrayList<>() ;
		users.add(new SpinnerDataClass("Mr.li", "shijiazhuang")) ;
		users.add(new SpinnerDataClass("Mr.du", "shijiazhuang")) ;
		users.add(new SpinnerDataClass("Mr.liu", "qinhuangddao")) ;
//		����Adapter����������
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
	 * SeekBar���������
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
	 * AutoCompleteTextView���������
	 */
	private void setAutoCompleteTextView(){
		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextVeiw) ;
		String [] counties = new String[] {"1", "12", "123", "1234", "12345", "123456"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, counties);
		autoCompleteTextView.setAdapter(adapter) ;
	}
	
}
