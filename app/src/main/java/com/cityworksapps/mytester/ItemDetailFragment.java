package com.cityworksapps.mytester;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.text.Html;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cityworksapps.mytester.dummy.DummyContent;

import java.io.InputStream;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
           String filetest = mItem.id + ".html";
           String bucko = AssetReaderToString(filetest);
        // Show the dummy content as text in a TextView.     mItem.content
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(Html.fromHtml(bucko));
        }

        return rootView;
    }

    public String AssetReaderToString(String filenamed) {

        StringBuilder buf=new StringBuilder();
        try {
            InputStream json = getActivity().getAssets().open(filenamed);
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(json));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
            return buf.toString();
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
