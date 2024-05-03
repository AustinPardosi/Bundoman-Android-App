// Generated by view binder compiler. Do not edit!
package com.example.bundoman.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bundoman.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentScanBinding implements ViewBinding {
  @NonNull
  private final View rootView;

  @NonNull
  public final ImageButton cameraButton;

  @NonNull
  public final ImageButton galleryButton;

  @NonNull
  public final ImageView scanImage;

  @NonNull
  public final Button sendBill;

  private FragmentScanBinding(@NonNull View rootView, @NonNull ImageButton cameraButton,
      @NonNull ImageButton galleryButton, @NonNull ImageView scanImage, @NonNull Button sendBill) {
    this.rootView = rootView;
    this.cameraButton = cameraButton;
    this.galleryButton = galleryButton;
    this.scanImage = scanImage;
    this.sendBill = sendBill;
  }

  @Override
  @NonNull
  public View getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentScanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_scan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentScanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cameraButton;
      ImageButton cameraButton = ViewBindings.findChildViewById(rootView, id);
      if (cameraButton == null) {
        break missingId;
      }

      id = R.id.galleryButton;
      ImageButton galleryButton = ViewBindings.findChildViewById(rootView, id);
      if (galleryButton == null) {
        break missingId;
      }

      id = R.id.scanImage;
      ImageView scanImage = ViewBindings.findChildViewById(rootView, id);
      if (scanImage == null) {
        break missingId;
      }

      id = R.id.sendBill;
      Button sendBill = ViewBindings.findChildViewById(rootView, id);
      if (sendBill == null) {
        break missingId;
      }

      return new FragmentScanBinding(rootView, cameraButton, galleryButton, scanImage, sendBill);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}