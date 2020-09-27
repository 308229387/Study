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
    private Button sendMessageButton;
    private int i;

    private SendActivityMessageListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.c_fragment, container, false);
        cText = view.findViewById(R.id.c_fragment_text);
        cButton = view.findViewById(R.id.c_fragment_button);
        sendMessageButton = view.findViewById(R.id.send_activity_button);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.send("这就是Fragment传过去的信息" + i);
                    i++;
                }
            }
        });

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

    public void setText(String text) {
        if (null != cText) {
            cText.setText(text);
        }
    }

    public void setListener(SendActivityMessageListener listener) {
        mListener = listener;
    }

    public interface SendActivityMessageListener {
        void send(String s);
    }

}
