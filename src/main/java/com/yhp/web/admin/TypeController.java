package com.yhp.web.admin;

import com.yhp.po.Type;
import com.yhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    //分十页，按照id排序，降序排列
    public String types(@PageableDefault(size = 3,
                                         sort = {"id"},
                                         direction = Sort.Direction.DESC)
                        Pageable pageable,
                        Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(){
        return "admin/types-input";
    }

    @PostMapping("/types")//启用方式为Post，不会冲突
    public String post(Type type, RedirectAttributes redirectAttributes){
        Type type1=typeService.saveType(type);
        if (type1==null){
            redirectAttributes.addFlashAttribute("message","操作失败！");
        }else{
            redirectAttributes.addFlashAttribute("message","操作成功！");
        }
        return "redirect:/admin/types";
    }
}
