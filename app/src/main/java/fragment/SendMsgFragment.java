package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.activity.R;

public class SendMsgFragment extends Fragment {
    SendMsgToActivityListener mListener;
    Button button;
    int i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.send_to_activity_fragment, container, false);
        button = view.findViewById(R.id.send_to_activity_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.send("我是来自Fragment的信息" + i);
                    i++;
                }
            }
        });
        return view;
    }

    public interface SendMsgToActivityListener {
        void send(String s);
    }

    public void setListener(SendMsgToActivityListener listener) {
        mListener = listener;
    }
}
