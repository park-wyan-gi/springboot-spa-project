package kr.jobtc.board;

import java.util.ArrayList;
import java.util.List;


public class BoardVo {
	int sno=0, grp, seq, deep, hit;
	String subject, nal, doc;
	String id;
    int attCnt;
    
    List<AttVo> attList = new ArrayList<AttVo>();

    
	public int getAttCnt() {
		return attCnt;
	}
	public void setAttCnt(int attCnt) {
		this.attCnt = attCnt;
	}
	public List<AttVo> getAttList() {
		return attList;
	}
	public void setAttList(List<AttVo> attList) {
		this.attList = attList;
	}
	public int getSno() {return sno;	}
	public void setSno(int sno) {this.sno = sno;	}
	public String getSubject() {return subject;	}
	public void setSubject(String subject) {this.subject = subject;	}
	public String getId() {return id;	}
	public void setId(String id) {this.id = id; }
	public int getGrp() {return grp;	}
	public void setGrp(int grp) {this.grp = grp;	}
	public int getSeq() {return seq;	}
	public void setSeq(int seq) {this.seq = seq;	}
	public int getDeep() {return deep;	}
	public void setDeep(int deep) {this.deep = deep;	}
	public int getHit() {return hit;	}
	public void setHit(int hit) {this.hit = hit;	}
	public String getNal() {return nal;	}
	public void setNal(String nal) {this.nal = nal;	}
	public String getDoc() {return doc;	}
	public void setDoc(String doc) {this.doc = doc;	}
	
	
}
