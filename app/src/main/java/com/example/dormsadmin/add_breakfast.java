package com.example.dormsadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class add_breakfast extends AppCompatActivity {
    Button add_button;
    ImageView menu_image;
    TextInputEditText i_name,mprice;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    StorageReference reference = FirebaseStorage.getInstance().getReference();
    Uri img_uri;
    DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("ADD ITEM");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_breakfast);


        add_button = findViewById(R.id.add_button2);
        menu_image = findViewById(R.id.menu_image);
        i_name=findViewById(R.id.i_name);
        mprice=(TextInputEditText)findViewById(R.id.price);
        menu_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(gallery,2);
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = i_name.getText().toString();
                root.child("Name").setValue(name);
                String price = mprice.getText().toString();
                root.child("Price").setValue(price);
                if (img_uri!= null){
                    upload_to_fb(img_uri);

                }else{
                    Toast.makeText(add_breakfast.this," Please Upload Image!",Toast.LENGTH_SHORT).show();

                }

            }


        });
    }
    public void openview_menu(){
        Intent intent = new Intent(this, view_menu.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null){
            img_uri = data.getData();
            menu_image.setImageURI(img_uri);

        }
    }
    private void upload_to_fb(Uri uri){
        StorageReference r1= reference.child(System.currentTimeMillis()+"."+getFileExtension(uri));
        r1.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                r1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        model m = new model(uri.toString());
                        String mID = root.push().getKey();
                        root.child("Image").child(mID).setValue(m);
                        Toast.makeText(add_breakfast.this,"uploaded successfully",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(add_breakfast.this,"uploading failed",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private  String getFileExtension(Uri mUri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }

}