# Spinner
Spinner,ListView,GridView
```
public class CustomActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Data> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        listView = (ListView)findViewById(R.id.listView);
        datas = Loader.getData();
        CustomAdapter adapter = new CustomAdapter(this,datas);
        listView.setAdapter(adapter);

    }
}
class CustomAdapter extends BaseAdapter{
    List<Data> datas = new ArrayList<>();
    LayoutInflater inflater;
    public CustomAdapter(Context context,ArrayList<Data> datas){
        this.datas = datas;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = inflater.inflate(R.layout.item_custom_list,null);
            holder = new Holder();
            holder.no = (TextView)view.findViewById(R.id.no);
            holder.title = (TextView)view.findViewById(R.id.title);
            view.setTag(holder);
        }else {
            holder = (Holder)view.getTag();
        }
        Data data = datas.get(i);
        holder.no.setText(data.getNo()+"");
        holder.title.setText(data.getTitle());
        return view;
    }
    class Holder{
        TextView no;
        TextView title;
    }
}
class Loader{
    public static ArrayList<Data> getData(){
        ArrayList<Data> result = new ArrayList<>();
        for(int i=0;i<100;i++){
            Data data = new Data();
            data.setNo(i+1);
            data.setTitle("타이틀"+i);
            result.add(data);
        }
        return result;
    }
}
class Data{
    private int no;
    private String title;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
