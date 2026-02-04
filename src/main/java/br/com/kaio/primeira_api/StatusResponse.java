package br.com.kaio.primeira_api;

public class StatusResponse {
    private String status;
    private String server;
    private String owner;

    public StatusResponse(String status, String server, String owner) {
        this.status = status;
        this.server = server;
        this.owner = owner;
    }

    public String getStatus() { return status; }
    public String getServer() { return server; }
    public String getOwner() { return owner; }
}
