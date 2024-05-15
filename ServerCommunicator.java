package com.example.tpi;

import android.os.AsyncTask;
import android.widget.Toast;
import java.io.*;
import java.net.*;

public class ServerCommunicator extends AsyncTask<String, Void, String> {

    private RegisterScreen1 context; // Referință către activitatea RegisterScreen1

    // Constructor care primește o referință către activitatea RegisterScreen1
    public ServerCommunicator(RegisterScreen1 context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String serverAddress = "192.168.88.160"; // Adresa IP a serverului
        int serverPort = 8080; // Portul pe care rulează serverul

        try {
            // Conectăm la server
            Socket socket = new Socket(serverAddress, serverPort);

            // Trimitem datele la server
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

            // Construim un mesaj care conține datele pentru a crea contul
            String message = "CREATE_ACCOUNT|" + params[0] + "|" + params[1] + "|" + params[2]; // De exemplu, email|username|password
            out.println(message);
            out.flush();

            // Așteptăm răspunsul de la server
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String response = in.readLine();

            // Închidem conexiunea cu serverul
            socket.close();

            // Returnăm răspunsul de la server
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return "Eroare la conectare cu serverul";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Aici poți gestiona răspunsul de la server (de exemplu, afișarea unui mesaj utilizatorului)
        if (result != null) {
            // Afiseaza un mesaj utilizatorului bazat pe raspunsul de la server
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        } else {
            // Daca raspunsul de la server este null, afiseaza un mesaj de eroare
            Toast.makeText(context, "Eroare la conectare cu serverul", Toast.LENGTH_SHORT).show();
        }
    }
}
