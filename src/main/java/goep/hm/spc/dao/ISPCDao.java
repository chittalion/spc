package goep.hm.spc.dao;

import goep.hm.spc.model.SpcResult;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

public interface ISPCDao extends Serializable {

	public void save(SpcResult spcResult);

	public List<SpcResult> findAll();
}
