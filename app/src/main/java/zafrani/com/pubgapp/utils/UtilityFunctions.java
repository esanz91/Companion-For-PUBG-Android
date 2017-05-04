package zafrani.com.pubgapp.utils;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import zafrani.com.pubgapp.models.ItemContainer;
import zafrani.com.pubgapp.models.ItemList;

public class UtilityFunctions {

    static final String TAG = UtilityFunctions.class.getSimpleName();

    public static ItemList generateItemList(Context context) {
        try {


            Gson gson = new GsonBuilder().serializeNulls().create();

            File f = new File(context.getCacheDir() + "/item.json");
            FileInputStream fileInputStream = new FileInputStream(f);


            /*
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    Log.e(TAG, line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JsonReader reader = new JsonReader(new FileReader(f));


            handleObject(reader);*/
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            ItemContainer items = load(inputStreamReader, ItemContainer.class);


            if (items != null) {
                Log.e(TAG, items.toString());
            } else {
                Log.e(TAG, "Item Container is empty.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T load(final InputStreamReader inputStreamReader, final Class<T> clazz) {
        try {
            if (inputStreamReader != null) {
                Log.e(TAG, "input stream reader is not null");
                final Gson gson = new Gson();
                final BufferedReader reader = new BufferedReader(inputStreamReader);
                return gson.fromJson(reader, clazz);
            }
        } catch (final Exception e) {
            Log.e(TAG, "load error. " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }

    private static void handleObject(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }

    /**
     * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
     * Arrays may contain objects or primitives.
     *
     * @param reader
     * @throws IOException
     */
    public static void handleArray(JsonReader reader) throws IOException {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token);
        }
    }

    /**
     * Handle non array non object tokens
     *
     * @param reader
     * @param token
     * @throws IOException
     */
    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException {
        if (token.equals(JsonToken.NAME))
            System.out.println(reader.nextName());
        else if (token.equals(JsonToken.STRING))
            System.out.println(reader.nextString());
        else if (token.equals(JsonToken.NUMBER))
            System.out.println(reader.nextDouble());
        else
            reader.skipValue();
    }
}



