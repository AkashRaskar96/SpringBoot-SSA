package com.adt.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SsnMasterGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="ADT_";
		String suffix="";
		
		try {
			Connection con=session.connection();
			Statement stmt=con.createStatement();
			String sql="Select ssn_seq.nextval from sequence_ssa";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				int seqval=rs.getInt(1);
				suffix=String.valueOf(seqval);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prefix+suffix;
	}

}
