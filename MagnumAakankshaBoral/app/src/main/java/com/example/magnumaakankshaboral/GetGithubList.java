package com.example.magnumaakankshaboral;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class GetGithubList extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static String url = "https://api.github.com/search/users?q=saransh&page=2";
    ArrayList<ArrayList<String>> github_list = new ArrayList<ArrayList<String>>();


    private class Json_Parsing extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServicecall(url);
            Log.e(TAG, "Response from URL: " + jsonStr);

            if (jsonStr != null) {
                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray contacts = jsonObj.getJSONArray("items");

                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("login");
                        String avatar_url = c.getString("avatar_url");

                        Log.e(TAG, "Login Id:-  " + id);
                        Log.e(TAG, "Login Name:-  " + name);
                        Log.e(TAG, "Avatar_url:-  " + avatar_url);


                        ArrayList<String> contact = new ArrayList<>();

                        contact.add(id);
                        contact.add(name);
                        contact.add(avatar_url);

                        github_list.add(contact);

                    }


                }
                catch (final JSONException e)
                {
                    e.printStackTrace();
                    Log.e(TAG, "JSON Parsing error: " + e.getMessage());

              /*  runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(this,"JSON Parsing Error: "+e.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });*/


                }
            } else {
                Log.e(TAG, "Couldn't get JSON from Server");
         /*   runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(getApplicationContext(),"Couldn't get JSON from Server, Check LogCat for possible errors!",Toast.LENGTH_LONG).show();
                }
            });*/
            }


            return null;
        }


    }


    public ArrayList<ArrayList<String>> return_arraylist()
    {
        return github_list;
    }
}
