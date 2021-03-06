package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.activity.R;

public class CFragment extends Fragment {
    private TextView cText;
    private Button cButton;
    private int i;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.c_fragment, container, false);
        cText = view.findViewById(R.id.c_fragment_text);
        cButton = view.findViewById(R.id.c_fragment_button);


        cButton.setOnClickListener(new ButtonClick());
        if (null != getArguments()) {
            cText.setText(getArguments().getString("data"));
        }


        return view;
    }


    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            cText.setText("我被点击了" + i);
            i++;
        }
    }
//初始化时传的值
    public void setText(String text) {
        if (null != cText) {
            cText.setText(text);
        }
    }


}
