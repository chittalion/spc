package goep.hm.spc.service;

import goep.hm.spc.model.SpcInput;
import goep.hm.spc.model.SpcResult;

import java.io.Serializable;
import java.util.List;

public interface ISPCService extends Serializable {

	public SpcResult sort(SpcInput input);

	public void saveResult(SpcResult spcResult);

	public List<SpcResult> listResult();
}
