package cniao5.com.admin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cniao5.com.admin.bean.Campaign;
import cniao5.com.admin.bean.HomeCampaign;
import cniao5.com.cniao5shop.R;

/**首页商品适配器
 * Created by Administration
 */
public class HomeCatgoryAdapter extends RecyclerView.Adapter<HomeCatgoryAdapter.ViewHolder> {

    private  static int VIEW_TYPE_L=0;//item 大图在左边显示
    private  static int VIEW_TYPE_R=1;//item 大图在右边显示

    private LayoutInflater mInflater;

    private List<HomeCampaign> mDatas;//数据源

    private  Context mContext;

    private  OnCampaignClickListener mListener;

    public HomeCatgoryAdapter(List<HomeCampaign> datas,Context context){
        mDatas = datas;
        this.mContext = context;
    }

    public void setOnCampaignClickListener(OnCampaignClickListener listener){

        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {

        mInflater = LayoutInflater.from(viewGroup.getContext());
        if(type == VIEW_TYPE_R){

            return  new ViewHolder(mInflater.inflate(R.layout.template_home_cardview2,viewGroup,false));
        }

        return  new ViewHolder(mInflater.inflate(R.layout.template_home_cardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        HomeCampaign homeCampaign = mDatas.get(i);
        viewHolder.textTitle.setText(homeCampaign.getTitle());

        Picasso.with(mContext).load(homeCampaign.getCpOne().getImgUrl()).into(viewHolder.imageViewBig);
        Picasso.with(mContext).load(homeCampaign.getCpTwo().getImgUrl()).into(viewHolder.imageViewSmallTop);
        Picasso.with(mContext).load(homeCampaign.getCpThree().getImgUrl()).into(viewHolder.imageViewSmallBottom);

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    @Override
    public int getItemViewType(int position) {

        if(position % 2==0){
            return  VIEW_TYPE_R;
        }
        else return VIEW_TYPE_L;


    }

      class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView textTitle;
        ImageView imageViewBig;
        ImageView imageViewSmallTop;
        ImageView imageViewSmallBottom;

        public ViewHolder(View itemView) {
            super(itemView);


            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            imageViewBig = (ImageView) itemView.findViewById(R.id.imgview_big);
            imageViewSmallTop = (ImageView) itemView.findViewById(R.id.imgview_small_top);
            imageViewSmallBottom = (ImageView) itemView.findViewById(R.id.imgview_small_bottom);


            imageViewBig.setOnClickListener(this);
            imageViewSmallTop.setOnClickListener(this);
            imageViewSmallBottom.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            HomeCampaign homeCampaign = mDatas.get(getLayoutPosition());
            if(mListener !=null){

                switch (v.getId()){

                    case  R.id.imgview_big:
                        mListener.onClick(v,homeCampaign.getCpOne());
                        break;

                    case  R.id.imgview_small_top:
                        mListener.onClick(v,homeCampaign.getCpTwo());
                        break;

                    case  R.id.imgview_small_bottom:
                        mListener.onClick(v,homeCampaign.getCpThree());
                        break;



                }
            }


        }
    }


    public  interface OnCampaignClickListener{


        void onClick(View view,Campaign campaign);

    }

}
