package com.example.learningmanagementsystem.view.home.category;

import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.databinding.CategoryRecyclerItemBinding;
import com.example.learningmanagementsystem.util.base.ViewModelFragment;
import com.example.learningmanagementsystem.view.MyHandler;

import java.util.List;
import java.util.Objects;

public class CategoryFragment extends ViewModelFragment<CategoryViewModel> {
    private RecyclerView mRecyclerView;
    private CategoryAdaptor mCategoryAdaptor;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void afterCreateVM(View root) {
        mRecyclerView = root.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSwipeRefreshLayout = root.findViewById(R.id.swipe);

        mCategoryAdaptor = new CategoryAdaptor(
                Objects.requireNonNull(getActivity()).getLayoutInflater(),
                null,
                R.layout.category_recycler_item,
                com.yuri.elearning.BR.category
        );
        mRecyclerView.setAdapter(mCategoryAdaptor);
        mVM.getCategoryLiveData().observe(getViewLifecycleOwner(), list -> {
            mCategoryAdaptor.setDataList(list);
            mSwipeRefreshLayout.setRefreshing(false);
        });
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(() -> mVM.refresh());

        mVM.refresh();
    }

    @Override
    protected void initVM() {
        mVM = ViewModelProviders.of(this).get(CategoryViewModel.class);
    }

    @Override
    protected void setMenu() {
        //ignore
    }

    @Override
    protected int getLayout() {
        return R.layout.category_fragment;
    }

    private static class CategoryAdaptor extends DataBindingRecyclerAdapter<CategoryRecyclerItemBinding, Category> {
        public CategoryAdaptor(LayoutInflater layoutInflater, List<Category> dataList, int layoutId, int brId) {
            super(layoutInflater, dataList, layoutId, brId);
        }

        @Override
        protected void initViewHolder(CategoryRecyclerItemBinding categoryRecyclerItemBinding) {
            categoryRecyclerItemBinding.setHandler(new MyHandler());
        }
    }
}
