package model.BLL;

import java.util.List;

public class AuxiliarServices extends GeneralServices  {


    protected AuxiliarServices(IDAO IDAO) {
        super(IDAO);
    }

    @Override
    public List read(int idShow) {
        return IDAO.read(idShow);
    }

    @Override
    public int create(Object o) {
        return IDAO.create(o);
    }


}
