package projetoengsof.engsoft.filters;

import projetoengsof.engsoft.models.BaseModel;

import java.util.Set;

public interface FilterI<T extends BaseModel> {
    Set<T> filter(Set<T> entities);
}
