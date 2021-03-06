package com.chen.baseextend.widget.tim;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.baseextend.R;


/**
 * Created by lt on 2016/8/6.
 */
public class DialogManager {

    private Dialog mDialog;

    private ImageView mIcon;
    private ImageView mVoice;
    private TextView mLabel;
    private TextView mTime;

    private Context mContext;

    public DialogManager(Context context) {
        mContext = context;
    }

    public void showRecordingDialog() {
        mDialog = new Dialog(mContext, R.style.Theme_AudioDialog);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(true);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_recorder, null);
        mDialog.setContentView(view);

        mIcon = (ImageView) mDialog.findViewById(R.id.id_recorder_dialog_icon);
        mVoice = (ImageView) mDialog.findViewById(R.id.id_recorder_dialog_voice);
        mLabel = (TextView) mDialog.findViewById(R.id.id_recorder_dialog_label);
        mTime = (TextView) mDialog.findViewById(R.id.id_recorder_dialog_time);

        mDialog.show();
    }

    public void recording() {
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLabel.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.ic_recorder);
            mLabel.setText("手指上滑，取消发送");
        }
    }

    public void wantToCancel() {
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLabel.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.ic_voice_cancel);
            mLabel.setText("松开手指，取消发送");
        }

    }

    public void toShort() {
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLabel.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.ic_voice_short);
            mLabel.setText("录音时间过短");
        }

    }

    public void dimissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }

    }

    /**
     * 通过level更新声音级别图片
     *
     * @param level
     */
    public void updateVoiceLevel(int level) {
        int resId = mContext.getResources().getIdentifier("ic_voice_" + level, "mipmap", mContext.getPackageName());
        mVoice.setImageResource(resId);
    }

    public void updateVoiceTime(float second) {
        mTime.setText("录制时长 " + (int)Math.rint(second) + "\"");
    }
}
