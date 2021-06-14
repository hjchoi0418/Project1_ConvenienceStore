import java.sql.Connection;

class jdbcConnection implements AutoCloseable{
	private Connection conn;
	private boolean using;
		
	public jdbcConnection() {
		conn = DBConnector.getConnection();
	}
		
	public boolean using() {
		return using;
	}
		
	public Connection use() {
		using = true;
		return conn;
	}
		
	@Override
	public void close() {
		using = false;
	}
}