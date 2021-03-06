package soal.tutorial.satu.model;

import java.util.Date;

/**
 * Created by agungwb on 11/02/2017.
 */
public class User {

    private Integer idPengguna;
    private String username;
    private String password;
    private String namaLengkap;
    private String NIK;
    private String noHp;
    private String email;
    private Date tglLahir;
    private String fotoFilePath;
    private String scanIjazahFilePath;
    private String scanKtpFilePath;
    private String scanSkckFilePath;
    private String scanNpwpFilePath;
    
    public Integer getIdPengguna() {
		return idPengguna;
	}
	public void setIdPengguna(Integer idPengguna) {
		this.idPengguna = idPengguna;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNamaLengkap() {
		return namaLengkap;
	}
	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}
	public String getNIK() {
		return NIK;
	}
	public void setNIK(String nIK) {
		NIK = nIK;
	}
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}
	public String getFotoFilePath() {
		return fotoFilePath;
	}
	public void setFotoFilePath(String fotoFilePath) {
		this.fotoFilePath = fotoFilePath;
	}
	public String getScanIjazahFilePath() {
		return scanIjazahFilePath;
	}
	public void setScanIjazahFilePath(String scanIjazahFilePath) {
		this.scanIjazahFilePath = scanIjazahFilePath;
	}
	public String getScanKtpFilePath() {
		return scanKtpFilePath;
	}
	public void setScanKtpFilePath(String scanKtpFilePath) {
		this.scanKtpFilePath = scanKtpFilePath;
	}
	public String getScanSkckFilePath() {
		return scanSkckFilePath;
	}
	public void setScanSkckFilePath(String scanSkckFilePath) {
		this.scanSkckFilePath = scanSkckFilePath;
	}
	public String getScanNpwpFilePath() {
		return scanNpwpFilePath;
	}
	public void setScanNpwpFilePath(String scanNpwpFilePath) {
		this.scanNpwpFilePath = scanNpwpFilePath;
	}
	public Boolean getFlagSynchronized() {
		return flagSynchronized;
	}
	public void setFlagSynchronized(Boolean flagSynchronized) {
		this.flagSynchronized = flagSynchronized;
	}
	public Boolean getFlagAktif() {
		return flagAktif;
	}
	public void setFlagAktif(Boolean flagAktif) {
		this.flagAktif = flagAktif;
	}
	private Boolean flagSynchronized;
    private Boolean flagAktif;

}
