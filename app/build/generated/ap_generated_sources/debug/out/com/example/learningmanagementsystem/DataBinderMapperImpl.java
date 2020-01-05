package com.example.learningmanagementsystem;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.learningmanagementsystem.databinding.CategoryRecyclerItemBindingImpl;
import com.example.learningmanagementsystem.databinding.CourseFragmentBindingImpl;
import com.example.learningmanagementsystem.databinding.CourseRecyclerItemBindingImpl;
import com.example.learningmanagementsystem.databinding.LessonFragmentBindingImpl;
import com.example.learningmanagementsystem.databinding.LessonItemBindingImpl;
import com.example.learningmanagementsystem.databinding.LessonMessageItemBindingImpl;
import com.example.learningmanagementsystem.databinding.ProfileFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CATEGORYRECYCLERITEM = 1;

  private static final int LAYOUT_COURSEFRAGMENT = 2;

  private static final int LAYOUT_COURSERECYCLERITEM = 3;

  private static final int LAYOUT_LESSONFRAGMENT = 4;

  private static final int LAYOUT_LESSONITEM = 5;

  private static final int LAYOUT_LESSONMESSAGEITEM = 6;

  private static final int LAYOUT_PROFILEFRAGMENT = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.category_recycler_item, LAYOUT_CATEGORYRECYCLERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.course_fragment, LAYOUT_COURSEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.course_recycler_item, LAYOUT_COURSERECYCLERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.lesson_fragment, LAYOUT_LESSONFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.lesson_item, LAYOUT_LESSONITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.lesson_message_item, LAYOUT_LESSONMESSAGEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.learningmanagementsystem.R.layout.profile_fragment, LAYOUT_PROFILEFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CATEGORYRECYCLERITEM: {
          if ("layout/category_recycler_item_0".equals(tag)) {
            return new CategoryRecyclerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_recycler_item is invalid. Received: " + tag);
        }
        case  LAYOUT_COURSEFRAGMENT: {
          if ("layout/course_fragment_0".equals(tag)) {
            return new CourseFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for course_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_COURSERECYCLERITEM: {
          if ("layout/course_recycler_item_0".equals(tag)) {
            return new CourseRecyclerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for course_recycler_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LESSONFRAGMENT: {
          if ("layout/lesson_fragment_0".equals(tag)) {
            return new LessonFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for lesson_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_LESSONITEM: {
          if ("layout/lesson_item_0".equals(tag)) {
            return new LessonItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for lesson_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LESSONMESSAGEITEM: {
          if ("layout/lesson_message_item_0".equals(tag)) {
            return new LessonMessageItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for lesson_message_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PROFILEFRAGMENT: {
          if ("layout/profile_fragment_0".equals(tag)) {
            return new ProfileFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for profile_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "handler");
      sKeys.put(2, "lesson_brief_info");
      sKeys.put(3, "lesson");
      sKeys.put(4, "course");
      sKeys.put(5, "category");
      sKeys.put(6, "user");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/category_recycler_item_0", com.example.learningmanagementsystem.R.layout.category_recycler_item);
      sKeys.put("layout/course_fragment_0", com.example.learningmanagementsystem.R.layout.course_fragment);
      sKeys.put("layout/course_recycler_item_0", com.example.learningmanagementsystem.R.layout.course_recycler_item);
      sKeys.put("layout/lesson_fragment_0", com.example.learningmanagementsystem.R.layout.lesson_fragment);
      sKeys.put("layout/lesson_item_0", com.example.learningmanagementsystem.R.layout.lesson_item);
      sKeys.put("layout/lesson_message_item_0", com.example.learningmanagementsystem.R.layout.lesson_message_item);
      sKeys.put("layout/profile_fragment_0", com.example.learningmanagementsystem.R.layout.profile_fragment);
    }
  }
}
