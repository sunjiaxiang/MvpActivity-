package com.example.mvpchouqu;

import com.example.mvpchouqu.Base.BasePresenter;
//p层
public class RequestPrenseter extends BasePresenter<RequestView> {

    private RequestModel model;

    @Override
    protected void initModel() {
        model = new RequestModel();
        baseModels.add(model);

     }
    public void getData(int pag) {
          model.getData(pag, new RexcRackCall() {
              @Override
              public void onSucess(ReBean reBean) {
             if (reBean!=null){
                 mview.geData(reBean);
             }
              }

              @Override
              public void onfile(String message) {
                  mview.showtact(message);
              }
          });
    }


}
