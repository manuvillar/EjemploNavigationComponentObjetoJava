package es.iesoretania.ejemplonavigationcomponentobjeto;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Datos implements Parcelable {
    String Texto;
    Integer numero;

    protected Datos(Parcel in) {
        Texto = in.readString();
        if (in.readByte() == 0) {
            numero = null;
        } else {
            numero = in.readInt();
        }
    }

    public static final Creator<Datos> CREATOR = new Creator<Datos>() {
        @Override
        public Datos createFromParcel(Parcel in) {
            return new Datos(in);
        }

        @Override
        public Datos[] newArray(int size) {
            return new Datos[size];
        }
    };

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Datos(String texto, Integer numero) {
        Texto = texto;
        this.numero = numero;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Texto);
        if (numero == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numero);
        }
    }
}
