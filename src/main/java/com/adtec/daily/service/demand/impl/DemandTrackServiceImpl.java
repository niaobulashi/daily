package com.adtec.daily.service.demand.impl;

import com.adtec.daily.bean.demand.DemandTrackExample;
import com.adtec.daily.bean.user.UserProject;
import com.adtec.daily.bean.user.UserProjectExample;
import com.adtec.daily.dao.demand.DemandTrackMapper;
import com.adtec.daily.dao.user.UserProjectMapper;
import com.adtec.daily.service.demand.DemandTrackService;
import com.adtec.daily.vo.DemandTrackVo;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandTrackServiceImpl implements DemandTrackService {

	@Autowired
    DemandTrackMapper demandTrackMapper;

    @Autowired
    UserProjectMapper userProjectMapper;


    @Override
    public List<DemandTrackVo> getDemandTrackList(DemandTrackVo demandTrack) {
        DemandTrackExample de = new DemandTrackExample();

        DemandTrackExample.Criteria ca = de.createCriteria();
        if (StringUtils.isNotEmpty(demandTrack.getDemandId())){
            ca.andDemandIdLike("%" + demandTrack.getDemandId() + "%");
        }
        if (StringUtils.isNotEmpty(demandTrack.getDemandName())){
            ca.andDemandNameLike("%" + demandTrack.getDemandName() + "%");
        }
        if (StringUtils.isNotEmpty(demandTrack.getDemandStat())){
            ca.andDemandStatEqualTo(demandTrack.getDemandStat());
        }
        if (StringUtils.isNotEmpty(demandTrack.getDemandRespoId())){
            ca.andDemandRespoIdEqualTo(demandTrack.getDemandRespoId());
        }
        if (StringUtils.isNotEmpty(demandTrack.getVersionNum())) {
            ca.andVersionNumLike("%" + demandTrack.getVersionNum() + "%");
        }

        de.setOrderByClause("create_time desc");
        return demandTrackMapper.selectByExample(de);
    }

    /**
     * 根据自定义语句查询
     *
     * @param demandTrack
     * @return
     */
    @Override
    public List<DemandTrackVo> getDemandTrackListBySql(DemandTrackVo demandTrack) {

        // 查询用户所在项目
        UserProjectExample upe = new UserProjectExample();
        UserProjectExample.Criteria uca = upe.createCriteria();
        uca.andUserIdEqualTo(demandTrack.getUserId());
        List<UserProject> userProjectList = userProjectMapper.selectByExample(upe);
        List<String> projectId = new ArrayList<>();
        if (userProjectList.size() > 0) {
            for (UserProject userProject : userProjectList) {
                projectId.add(userProject.getProjectId().toString());
            }
        } else {
            return null;
        }


        DemandTrackExample de = new DemandTrackExample();
        DemandTrackExample.Criteria ca = de.createCriteria();

        if (projectId.size() > 0) {
            ca.andProjectIdIn(projectId);
        } else {
            return null;
        }

        PageHelper.startPage(demandTrack.getPage(), demandTrack.getLimit());

        if (StringUtils.isNotEmpty(demandTrack.getDemandId())) {
            ca.andDemandIdLike("%" + demandTrack.getDemandId() + "%");
        }
        if (StringUtils.isNotEmpty(demandTrack.getDemandName())) {
            ca.andDemandNameLike("%" + demandTrack.getDemandName() + "%");
        }
        if (StringUtils.isNotEmpty(demandTrack.getDemandStat())) {
            ca.andDemandStatEqualTo(demandTrack.getDemandStat());
        }
        if (StringUtils.isNotEmpty(demandTrack.getDemandRespoId())) {
            ca.andDemandRespoIdEqualTo(demandTrack.getDemandRespoId());
        }
        if (StringUtils.isNotEmpty(demandTrack.getVersionNum())) {
            ca.andVersionNumLike("%" + demandTrack.getVersionNum() + "%");
        }

        return demandTrackMapper.select(de);
    }

    @Override
    public int addDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.insertSelective(demandTrack);
    }

    @Override
    public int delDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.deleteByPrimaryKey(demandTrack);
    }

    @Override
    public int updateDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.updateByPrimaryKeySelective(demandTrack);
    }

    @Override
    public DemandTrackVo queryDemandTrack(DemandTrackVo demandTrack) {
        return demandTrackMapper.selectByPrimaryKey(demandTrack);
    }
}
