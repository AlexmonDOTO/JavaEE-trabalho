package locadora.filme.dal.dao.interfaces;

import locadora.filme.dal.generics.*;
import locadora.filme.dal.entidade.*;
import java.util.*;

public interface INomeFilmeDAO
		extends IGenericDAO<NomeFilme, Short>{

	public List<NomeFilme> findByDiretor(String nomeDiretor);
}
