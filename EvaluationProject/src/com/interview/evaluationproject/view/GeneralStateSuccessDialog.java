package com.interview.evaluationproject.view;

import com.interview.evaluationproject.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public class GeneralStateSuccessDialog extends DialogFragment {

	Context m_context;
	String m_title;
	String m_message;
	
	public GeneralStateSuccessDialog(Context context, String title, String message){
		this.m_context = context;
		this.m_title = title;
		this.m_message = message;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(m_title)
				.setMessage(m_message)
				.setPositiveButton(
						m_context.getString(R.string.ok),
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// open settings
								GeneralStateSuccessDialog.this.getDialog().cancel();
							}
						});

		return builder.create();
	}
}
